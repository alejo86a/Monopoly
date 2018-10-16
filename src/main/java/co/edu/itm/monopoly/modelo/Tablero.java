package co.edu.itm.monopoly.modelo;

public class Tablero {
	
	Object tablero [] = new Object [40];
	
	Casilla casilla1;
	
	Casilla casilla2;
	
	Casilla casilla3;
	
	Casilla casilla4;
	
	Casilla casilla5;
	
	Casilla casilla6;
	
	Casilla casilla7;
	
	Casilla casilla8;
	
	Casilla casilla9;
	
	Casilla casilla10;
	
	Casilla casilla11;
	
	Casilla casilla12;
	
	Casilla casilla13;
	
	Casilla casilla14;
	
	Casilla casilla15;
	
	Casilla casilla16;
	
	Casilla casilla17;
	
	Casilla casilla18;
	
	Casilla casilla19;
	
	Casilla casilla20;
	
	Casilla casilla21;
	
	Casilla casilla22;
	
	Casilla casilla23;
	
	Casilla casilla24;
	
	Casilla casilla25;
	
	Casilla casilla26;
	
	Casilla casilla27;
	
	Casilla casilla28;
	
	Casilla casilla29;
	
	Casilla casilla30;

	Casilla casilla31;
	
	Casilla casilla32;
	
	Casilla casilla33;
	
	Casilla casilla34;
	
	Casilla casilla35;
	
	Casilla casilla36;
	
	Casilla casilla37;
	
	Casilla casilla38;
	
	Casilla casilla39;
	
	Casilla casilla40;
	
	public Tablero(){
	
		casilla1= new Salida(1, 715, 718);
		
		casilla2= new Propiedad("Parque pies descalzos" ,60 , 2, 10, 30, 90, 160, 250
				, 2, 616, 718, "cafe", 30, false, false, 50, 50);
		
		casilla3= new TarArcaComunal(3, 554, 718);
		
		casilla4= new Propiedad("Parque de las luces", 60, 4, 20, 60, 180, 320, 450
				, 4, 492, 718, "cafe", 30, false, false, 50, 50);
		
		casilla5= new Impuesto("Impusto por bienes", 5, 428, 718);
		
		casilla6= new Metro("Metro plus", 6, 368, 718);
		
		casilla7= new Propiedad("Estadio Atanacion Girardot", 100, 6, 30, 90, 270, 400
				, 500, 7, 303, 718, "azul claro", 50, false, false, 50, 50);
		
		casilla8= new TarCasualidad(8, 238, 718);
		
		casilla9= new Propiedad("Apujarra", 100, 8, 40, 100, 300, 450, 600, 9, 175, 718
				, "azul claro", 50, false, false, 50, 50);
		
		casilla10= new Propiedad("Edificio Coltejer", 120, 8, 40, 100, 300, 450, 600
				, 10, 113, 718, "azul claro", 60, false, false, 50, 50);
		
		casilla11= new Carcel(11, 43, 718);
		
		casilla12= new Propiedad("Parque biblioteca Belen", 140, 10, 50, 150, 450, 625
				, 750, 12, 11, 656, "rosado", 70, false, false, 100, 100);
		
		casilla13= new EmPublicas("Electrica EPM", 13, 11, 554);
		
		casilla14= new Propiedad("Biblioteca publica piloto", 140, 10, 50, 150, 450, 625
				, 750, 14, 11, 493, "rosado", 70, false, false, 100, 100);
		
		casilla15= new Propiedad("Biblioteca la ladera", 160, 12, 60, 180, 500, 700, 900
				, 15, 11, 430, "rosado", 80, false, false, 100, 100);
		
		casilla16= new Metro("Metro cable", 16, 11, 364);
		
		casilla17= new Propiedad("Cerro nutibara", 180, 14, 70, 200, 550, 750, 950, 17
				, 11, 303, "naranja", 90, false, false, 100, 100);
		
		casilla18= new TarArcaComunal(18, 11, 238);
		
		casilla19= new Propiedad("Cerro el volador", 180, 14, 70, 200, 550, 750, 950, 19
				, 11, 175, "naranja", 90, false, false, 100, 100);
		
	    casilla20= new Propiedad("Cerro de las 3 cruces", 200, 16, 80, 220, 600, 800, 1000, 20
				, 11, 115, "naranja", 100, false, false, 100, 100);
		
		casilla21= new ParadaLibre(21, 11, 11);
		
		casilla22= new Propiedad("Calle Barranquilla", 220, 18, 90, 250, 700, 875, 1050, 22
				, 115, 11, "rojo", 110, false, false, 150, 150);
		
		casilla23= new TarCasualidad(23, 175, 11);
		
		casilla24= new Propiedad("Calle Colombia", 220, 18, 90, 250, 700, 875, 1050, 24
				, 240, 11, "rojo", 110, false, false, 150, 150);
		
		casilla25= new Propiedad("Calle San Juan", 240, 20, 100, 300, 750, 925, 1100, 25
				, 300, 11, "rojo", 120, false, false, 150, 150);
		
		casilla26= new Metro("Metro Tranvia", 26, 565, 11);
		
		casilla27= new Propiedad("Avenida Oriental", 260, 22, 110, 330, 800, 975, 1150, 27
				, 430, 11, "amarillo", 130, false, false, 150, 150);
		
		casilla28= new Propiedad("Avenida Regional", 260, 22, 110, 330, 800, 975, 1150, 28
				, 490, 11, "amarillo", 130, false, false, 150, 150);
		
		casilla29= new EmPublicas("Agua EPM", 29, 555, 11);
		
		casilla30= new Propiedad("Avenida las palmas", 280, 22, 120, 360, 850, 1025, 1200, 30
				, 617, 11, "amarillo", 140, false, false, 150, 150);
	
		casilla31= new Carcel(31, 715, 11);
		
		casilla32= new Propiedad("CC. El tesoro", 300, 26, 130, 390, 900, 1100, 1275, 32
				, 715, 115, "verde", 150, false, false, 200, 200);
		
		casilla33= new Propiedad("CC. El Mayorca", 300, 26, 130, 390, 900, 1100, 1275, 33
				, 715, 175, "verde", 150, false, false, 200, 200);
		
		casilla34= new TarArcaComunal(34, 715, 232);
		
		casilla35= new Propiedad("CC. San Diego", 320, 28, 150, 450, 1000, 1200, 1400, 35
				, 715, 300, "verde", 160, false, false, 200, 200);
		
		casilla36= new Metro("Metro", 36, 715, 362);
		
		casilla37= new TarCasualidad(37, 715, 428);
		
		casilla38= new Propiedad("Universidad de Antioquia", 400, 35, 175, 500, 1100, 1300, 1500, 38
				, 715, 490, "azul", 175, false, false, 200, 200);
		
		casilla39= new Impuesto("Impuesto por lujos", 39, 715, 554);
		
		casilla40= new Propiedad("Universidad Nacional", 350, 50, 200, 600, 1400, 1700, 2000, 40
				, 715, 620, "azul", 200, false, false, 200, 200);
		
		tablero [0] = casilla1;
		tablero [1] = casilla2;
		tablero [2] = casilla3;
		tablero [3] = casilla4;
		tablero [4] = casilla5;
		tablero [5] = casilla6;
		tablero [6] = casilla7;
		tablero [7] = casilla8;
		tablero [8] = casilla9;
		tablero [9] = casilla10;
		tablero [10] = casilla11;
		tablero [11] = casilla12;
		tablero [12] = casilla13;
		tablero [13] = casilla14;
		tablero [14] = casilla15;
		tablero [15] = casilla16;
		tablero [16] = casilla17;
		tablero [17] = casilla18;
		tablero [18] = casilla19;
		tablero [19] = casilla20;
		tablero [20] = casilla21;
		tablero [21] = casilla22;
		tablero [22] = casilla23;
		tablero [23] = casilla24;
		tablero [24] = casilla25;
		tablero [25] = casilla26;
		tablero [26] = casilla27;
		tablero [27] = casilla28;
		tablero [28] = casilla29;
		tablero [29] = casilla30;
		tablero [30] = casilla31;
		tablero [31] = casilla32;
		tablero [32] = casilla33;
		tablero [33] = casilla34;
		tablero [34] = casilla35;
		tablero [35] = casilla36;
		tablero [36] = casilla37;
		tablero [37] = casilla38;
		tablero [38] = casilla39;
		tablero [39] = casilla40;		
	}
	
	public Casilla retornaPorPosicion(int pos){
		return (Casilla) tablero[pos+1];
	}

}
