#!/bin/sh
echo "Unpackeage dependency"
rm -r ./out
mkdir -p ./out/tmp
unzip -o commons-text-1.8.jar -d ./out/tmp/libs 1>/dev/null
unzip -o commons-lang3-3.0.jar -d ./out/tmp/libs 1>/dev/null

echo "Create file"
mkdir -p ./src/main/com/epam
cat > ./src/main/com/epam/Pretty.java <<EOF
package com.epam;

import org.apache.commons.text.WordUtils;

public class Pretty {
    public static void main(String[] args) {
        for(String st : args) {
            System.out.println(WordUtils.swapCase(st));
        }
    }
}

EOF

echo "compile class"
javac -d ./out/jar -cp ./commons-text-1.8.jar ./src/main/com/epam/Pretty.java

echo "create manifest"
mkdir -p ./src/resources/META-INF
cat > ./src/resources/META-INF/MANIFEST.FM <<EOF
Class-Path: .
Main-Class: com.epam.Pretty

EOF

echo "make jar"
jar vcmf ./src/resources/META-INF/MANIFEST.FM ./out/pretty.jar -C ./out/tmp/libs org -C ./out/jar/ .

echo "remove libs"
rm -r ./out/tmp ./out/jar

echo "run application"
java -jar ./out/pretty.jar first SECOND Third