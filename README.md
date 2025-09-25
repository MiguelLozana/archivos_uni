Configuracion de git:
git config --global user.name "MiguelLozana"
git config --global user.email "miguellozanacueto@gmail.com"
git config --global credential.helper store

git init
git branch -M main
git remote add origin https://github.com/MiguelLozana/archivos_uni.git

echo "CONFIGIT/cong.txt" >> .gitignore
git add .gitignore
git commit -m "Ignorar archivos de configuración local"

git add .
git commit -m "Primer commit limpio"
git push -u origin main
------------------------------
git remote remove origin
