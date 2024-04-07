package ejercicio3;

public class Test {
	public static void main(String[] args) {
		Estudiante[] estudiantes=new Estudiante[2];
		Profesor[] profesores=new Profesor[3];
		
		estudiantes[0]=new Estudiante("juan","rueda","3A","juanbarueda@gmail.com","rojas 1210");
		estudiantes[1]=new Estudiante("ramon","rueda","5A","el_pepo2010@gmail.com","roberto 304");
		
		profesores[0]= new Profesor("ramon","gomez","ramaRama23@gmail.com","3A","UNLP");
		profesores[1]= new Profesor("javier","ramirez","rojoElCulo@gmail.com","8C","UNLP");
		profesores[2]= new Profesor("jackson","samuel","boca2001@yahoo.com.ar","4D","UNLP");
		
		System.out.println("estudiantes:");
		for(int j=0;j<2;j++) {
			System.out.println(estudiantes[j].tusDatos());
		}
		System.out.println("profesores:");
		for(int i=0;i<3;i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
}
