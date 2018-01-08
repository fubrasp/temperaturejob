## Etapes

1. Ecrire Mapper, Reducer, Programme
2. Créer archive
3. Tester sur un échantillon
4. Test sur fichier.
5. Psser en mode pseudo distribué

## Compilation
```bash
hadoop com.sun.tools.javac.Main *.java
```

## Création de l'archive
```bash
javac -classpath `yarn classpath` -d . *.java
java cf MaxTemp.jar *.class
```

## Exécution du jar
```bash
hadoop jar MaxTemp.jar Temperature.java
```

## aller dans le résultat
```bash
cd out
```

## hadoop method
```bash
hadoop archive -archiveName myhar.har /input/location /output/location
```