# gunsshop
git init - создать гит репозиторий в папке

git status - состояние рабочей директории

git add . - подготовить данные для коммита

git commit -am "комментарий" - создать коммит

git log - просмотреть историй коммитов (для выхода нажать q)

git branch name - созать ветку с именем name 

git branch -m oldname newname - переименовать ветку в newname

git checkout name - переключиться на ветку с именем name 

git checkout -b name - создать ветку name и сразу переключиться на нее

git merge name - объединить текущую ветку с веткой name 

git commit --amend - изменить последний коммит. Если не делать 
git add . , то изменит только комментарий, если сделать, то поменяется состояние кода.

git clone https://github.com/distortionMs/gunsshop.git

git remote add origin https://github.com/distortionMs/gunsshop.git

pit push/pull origin branchname - загрузить/получить код из репозитория origin
