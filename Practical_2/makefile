all:
	make clean && make main && java Main

main:
	javac *.java

clean:
	rm -f *.class

coverage:
	rm -rf org*/ jacoco-resources default com*/ 
	rm -f *.class *.html *.exec *.xml *.csv
	javac *.java
	rm -rf cov
	mkdir -p ./cov
	java -javaagent:jacocoagent.jar=excludes=org.jacoco.*,destfile=./cov/output.exec -cp ./ Main
	mv *.class ./cov
	java -jar ./jacococli.jar report ./cov/output.exec --classfiles ./cov --sourcefiles ./ --html ./cov/report
