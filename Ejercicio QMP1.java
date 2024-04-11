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

    constant ZAPATO = new TipoPrenda(PIES);
    constant CAMISA_CORTA = new TipoPrenda(TORSO);
    constant PANTALON = new TipoPrenda(PIERNAS);
    constant SACO = new TipoPrenda(TORSO);
    constant COLLAR = new TipoPrenda(CUELLO);
    constant MEDIAS = new TipoPrenda(PIES);
    constant POLLETA = new TipoPrenda(PIERNAS);
    constant ANTEOJOS = new TipoPrenda(CABEZA);
    constant ZAPATILLAS = new TipoPrenda(PIES);
    constant GORRO = new TipoPrenda(CABEZA);
}

//Categoria de la prenda
public enum Categoria {
    CABEZA,CUELLO,TORSO,BRAZOS,MANOS,PIERNAS,PIES
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
en donde salga que tiene muchas prendas porque de momento no se especifica como se lleva a cabo el atuendo, asi que no 
debemos centrarnos en ello porque no es el foco en este momento.
Primero se tienen que validar las cuestiones de la prenda para crear el autendo.
En la clase prenda se componen sus atributos sin ser Strings porque los String si se necesitan comparar luego
o usarlos en otra instancia y se escriben con un solo caracter distinto rompe.
Para el tipo de la prenda se creo una clase TipoPrenda en donde allí se engloba tambien la categoria porque se
ve conveniente que el tipo de prenda este en conjunto con su categoria para aportar robustez sin requerir a tantas
validaciones if en el camino, ya que se debe contemplar con cada tipo de prenda a que categoria del cuerpo pertenece, asi 
que alli fueron creados algunos objetos TipoPrenda como ejemplo con sus respectivas categorias.
Luego los materiales y los colores fueron diseñados con enums para mas sencilles.
Por ultimo siguiendo en la clase Prenda, se hace la respectiva validacion de si la prenda es valida o no segun si se han puesto
los atributos necesarios. Si no se han puesto los atributos necesarios se valida con una excepcion de PrendaNoApta para crear
el atuendo.
*/