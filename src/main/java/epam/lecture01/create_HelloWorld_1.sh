sh ./clean.sh
echo "Creates directories"
mkdir -p ./src/com/courses
mkdir ./out

echo "Creates Hello.java"
cat >> ./src/com/courses/Hello.java<<EOF
package com.courses;

public class Hello {
   public static void main(String[] args) {
       System.out.println("Hello, World!");
   }
}
EOF

echo "Compile"
javac -d ./out ./src/com/courses/Hello.java
echo "Execute:"
java -cp ./out com.courses.Hello

#remove directories if execute with key -c
for param in "$@"; do
  case $param in
      -clean|-c|clean)
          sh ./clean.sh
      ;;
  esac
done