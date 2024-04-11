//PSEUDOCODIGO

class Prenda{
    TipoPrenda tipo;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;

    public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario){
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    method esValida(TipoPrenda tipo, Material material, Color colorPrincipal){
        if(colorPrincipal == null  || tipo == null || material == null){
            throw new PrendaNoAptaException( "Faltan cargar datos requeridos" );
        }
    }
    
}

//Tipo de la prenda

class TipoPrenda{
    Categoria categoria;

    method categoria() { return this.categoria; }

    constant ZAPATO = new TipoPrenda(CALZADO);
    constant CAMISA_CORTA = new TipoPrenda(PARTE_SUPERIOR);
    constant PANTALON = new TipoPrenda(PARTE_INFERIOR);
    constant SACO = new TipoPrenda(PARTE_SUPERIOR);
    constant COLLAR = new TipoPrenda(ACCESORIO);
    constant POLLERA = new TipoPrenda(PARTE_INFERIOR);
    constant ANTEOJOS = new TipoPrenda(ACCESORIO);
    constant ZAPATILLAS = new TipoPrenda(CALZADO);
    constant GORRO = new TipoPrenda(ACCESORIO);
}

//Categoria de la prenda
public enum Categoria {
    PARTE_SUPERIOR, CALZADO, PARTE_INFERIOR, ACCESORIO
} 

 //Material con el que esta hecha la prenda
public enum Material {
    JEAN, ALGODON, CUERO, LANA, POLIESTER
}

//Colores
public enum Color {
    ROJO, VERDE, AMARILLO, AZUL, NEGRO, BLANCO, GRIS, VIOLETA, NARANJA, ROSA
}


//EXPLICACION - PROSA
/*
Se crea una clase Prenda directamente ya que puede haber varias prendas en un atuendo. No una clase anterior Atuendo 
en donde salga que tiene muchas prendas porque de momento no se especifica como se lleva a cabo el atuendo o como generarlo, 
asi que no debemos tomarlo en cuenta porque no es el foco del requerimiento y ademas no debe quedar una clase sin comportamiento.
Primero se tienen que validar las cuestiones de la prenda para crear el autendo.
En la clase prenda se componen sus atributos (tipo,material,colores) sin ser Strings porque los String, si se necesitan comparar luego
o usarlos en otra instancia, se pueden escribir con un error en un solo caracter y rompe.
Para el tipo de la prenda se creo una clase TipoPrenda (son varios tipos) en donde allí se engloba tambien la categoria de los mismos
porque se ve conveniente que el tipo de prenda este en conjunto con su categoria para aportar robustez y abstaccion sin requerir a tantas
validaciones if en el camino (donde lo convertiria en codigo mas algoritmico/iperativo), ya que se debe contemplar con cada tipo de prenda 
a que categoria del cuerpo pertenece, asi que alli fueron creados algunos objetos TipoPrenda como ejemplo con sus respectivas categorias.
Luego los materiales y los colores fueron diseñados con enums para mas simplicidad (aunque no se toman en cuenta todas las posibilidades
pero en el requirimiento no aclara).
Por ultimo siguiendo en la clase Prenda, se hace la respectiva validacion de si la prenda es valida o no segun si se han puesto todos los
los atributos necesarios. Si no se han puesto los atributos necesarios se valida con una excepcion de PrendaNoApta para crear el atuendo.
*/
