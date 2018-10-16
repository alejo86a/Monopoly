Jouons au Monopoly
==================

*Auteurs :*
----------
[Maxime Caboche](https://github.com/mcaboche), [Fouad Zairi](https://github.com/fosonaf)

*Lancer le jeu à partir du jar*
-----------------------------
- Ouvrez un terminal.
- Décompressez l'archive avec la commande : `tar xvf monopoly.tar.gz`
- Placez vous à la racine du dossier monopoly
- Puis tapez la commande : `java -jar monopoly.jar`


*Compiler le jeu à partir des sources*
------------------------------------
- Ouvrez un terminal.
- Placez vous à la racine du dossier monopoly
- Tapez la commande : javac -sourcepath sources/ -d classes/ sources/monopoly/gui/Plateau.java 


*Lancer le jeu à partir des fichier classes*
------------------------------------------
- Ouvrez un terminal.
- Placez vous à la racine du dossier monopoly
- Tapez la commande : java -cp classes/ monopoly.gui.Plateau 
