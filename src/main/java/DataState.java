
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aleksey
 */
public class DataState {

    private ArrayList<EquipmentRow> primaryData = new ArrayList<>();
    private ArrayList<EquipmentRow> currentData = new ArrayList<>();

    public ArrayList<EquipmentRow> toInsert = new ArrayList<EquipmentRow>();
    public ArrayList<EquipmentRow> toUpdate = new ArrayList<EquipmentRow>();
    public ArrayList<EquipmentRow> toDelete = new ArrayList<EquipmentRow>();

    public DataState(ArrayList<EquipmentRow> aPrimaryData, ArrayList<EquipmentRow> aCurrentData) {
        this.primaryData = aPrimaryData;
        this.currentData = aCurrentData;
        checkForChanges();
        checkForDeletion();
    }

    private void checkForChanges() {
        for (int i = 0; i < currentData.size(); i++) {
            if (currentData.get(i).id > 0) { //У новых записей id пустой - они будут обработаны ниже, здесь проверяем были ли изменения в уже существующих строках для этого:
                for (int j = 0; j < primaryData.size(); j++) {  //Идём по всей коллекции старых значений и ищем с таким же id
                    if (currentData.get(i).id == primaryData.get(j).id) {
                        if (!currentData.get(i).compareRow(primaryData.get(j))) { // Если одно из полей не совпадает, то добавляем в UpdateVal для обновления значений
                            toUpdate.add(currentData.get(i)); //Если одно из значений изменилось - "запоминаем" эту строку в коллекции "для UPDATE
                        }
                        break;  // Нашли нужный id - выходим из цикла по старым значениям
                    }
                }
            } else {
                toInsert.add(currentData.get(i)); // Сюда мы попадаем, если id пустой, то есть была добавлена новая строка - "запомним" для INSERT
            }
        }
    }

    private void checkForDeletion() {
        //А теперь надо проверить - не удалили ли мы какую-нибудь строку
        for (int j = 0; j < primaryData.size(); j++) {
            boolean not_founded = true;
            for (int i = 0; i < currentData.size(); i++) {
                if (primaryData.get(j).id == currentData.get(i).id) {
                    not_founded = false;
                    break;
                }
            }
            if (not_founded) {
                toDelete.add(primaryData.get(j));
            }
        }
    }
}
