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

   public String greeting() {
       return "Hello, World!";
   }
}
EOF

echo "Creates Hello2.java"
mkdir -p ./src/com/java
cat >> ./src/com/java/Hello2.java<<EOF
package com.java;

import com.courses.Hello;

public class Hello2 {
   public static void main(String[] args) {
       System.out.println(new Hello().greeting());
   }
}
EOF

echo "Compile"
javac -d ./out ./src/com/courses/Hello.java ./src/com/java/Hello2.java
echo "Execute:"
java -cp ./out com.java.Hello2

#remove directories if execute with key -c
for param in "$@"; do
  case $param in
      -clean|-c|clean)
          sh ./clean.sh
      ;;
  esac
done