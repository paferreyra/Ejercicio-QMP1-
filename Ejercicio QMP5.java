//PSEUDOCODIGO
//----------------------- QMP5 ---------------------------

//QMP4

//QMP3 (opcional) (copiado de clase)
enum Formalidad{
    FORMAL,INFORMAL,NEUTRA
}

class Sugerencia{
    Prenda superior;
    Prenda inferior;
    Prenda calzado;

    public Sugerencia(Prenda superior,Prenda inferior,Prenda calzado){
        this.superior=superior;
        this.inferior=inferior;
        this.calzado=calzado;
    }
}

class Usuario{
    List<Prenda> prendas = [];
    Integer edad;
    MotorSugerencias motor;

    public Usuario(Integer edad,MotorSugerencias motor){
        this.edad=edad;
        this.motor=motor;
    }
    List<Sugerencia> generarSugerencias(){
        return this.motor.generarSugerencias(this);
    }
}

interface MotorSugerencias{
    List<Sugerencia> genererSugerencias(Usuario usuario);
}

class MotorSugerenciasFormalidad implements MotorSugerencias {
    List<Prenda> getPrendasValidas(Usuario usuario) {
        return usuario.getEdad() > 55 ? usuario.getPrendas().filter(p -> !p.isInformal()) : usuario.getPrendas();
    }

    List<Sugerencia> generarSugerencias(Usuario usuario) {
        List<Prenda> prendasSuperiores = this.getPrendasValidas(usuario).filter(p -> p.esSuperior());
        List<Prenda> prendasInferiores = this.getPrendasValidas(usuario).filter(p -> p.esinferior());
        List<Prenda> calzados = this.getPrendasValidas(usuario).filter(p -> p.esCalzado());
    }

    List<List<Prenda>> combinaciones

    {
        Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados)
        return combinaciones.map(c -> new Sugerencia(c[0], c[1], c[2]))
    }
}
class MotorSugerenciasBasico implements MotorSugerencias {

    //TODO no repetir esta logica
    List<Sugerencia> generarSugerencias(Usuario usuario){
        List<Prenda> prendasSuperiores = usuario.getPrendas().filter(p -> p.esSuperior());
        List<Prenda> prendasInferiores = usuario.getPrendas().filter(p -> p.esinferior());
        List<Prenda> calzados = usuario.getPrendas().filter(p -> p.esCalzado());

        List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores, prendasInferiores, calzados)

        return combinaciones.map(c -> new Sugerencia(c[0], c[1], c[2]))
    }

}
class ProveedorDeMotor{
    static MotorSugerencias motor;

    static MotorSugerencias getMotor(){
        return motor;
    }

    static setMotor(MotorSugerencias motor){
        ProveedorDeMotor.motor = motor;
    }
}

}

//QMP2

class Borrador{
    TipoPrenda tipo;
    Material material;
    Color colorPrincipal;
    TipoTela trama = TipoTela.LISA;

    void Tipo(TipoPrenda tipo){
        if(tipo == null){
            throw new IllegalArgumentException("Prenda sin TIPO");
        }
    }

    void Material(Material material){
        if(material == null){
            throw new IllegalArgumentException("Prenda sin MATERIAL");
        }
        if(this.tipo == null){
            throw new IllegalArgumentException("El TIPO debe estar seteado antes que el MATERIAL");
        }
        if(this.esCompatible(material)){
            throw new IllegalArgumentException("El MATERIAL debe ser compatible con el TIPO");
        }
    }
    void Color(Color colorPrincipal){
        if(colorPrincipal == null){
            throw new IllegalArgumentException("No hay COLOR");
        }
    }

    Prenda construirPrenda(){
        if(this.colorPrincipal == null){
            throw new IllegalArgumentException("Falta el COLOR PRINCIPAL");
            return new Prenda(this.material,this.tipo,this.colorPrincipal,this.colorSecundario,this.trama);
        }
    }
}

class Uniforme{
    method hacerUniforme(Instituto instituto){
        return new Uniforme(instituto.parteSuperior(), instituto.parteInferior(),instituto.calzado());
    }
}

interface Instituto{
    method parteSuperior();
    method parteInferior();
    method calzado();
}

class InstitutoSanJuan implements Instituto{
    method parteSuperior(){
        borrador = new Borrador(CHOMBA),
            borrador.Color(new Color(VERDE)),
            borrador.Material(new Material(PIRQUE)),
        return borrador.contruirPrenda();
    }
    method parteInferior(){
        borrador = new Borrador(PANTALON),
            borrador.Color(new Color(GRIS)),
            borrador.Material(new Material(ACETATO)),
        return borrador.contruirPrenda();
    }
    method parteInferior(){
        borrador = new Borrador(ZAPATILLA),
            borrador.Color(new Color(BLANCO)),
            borrador.Material(new Material(CUERO)),
        return borrador.contruirPrenda();
    }
}

class InstitutoJohnson implements Instituto{
    method parteSuperior(){
        borrador = new Borrador(CAMISA),
            borrador.Color(new Color(BLANCO)),
            borrador.Material(new Material(ALGODON)),
        return borrador.contruirPrenda();
    }
    method parteInferior(){
        borrador = new Borrador(PANTALON),
            borrador.Color(new Color(NEGRO)),
            borrador.Material(new Material(MEZCLILLA)),
        return borrador.contruirPrenda();
    }
    method parteInferior(){
        borrador = new Borrador(ZAPATO),
            borrador.Color(new Color(NEGRO)),
            borrador.Material(new Material(CUERO)),
        return borrador.contruirPrenda();
    }
}
//EXPLICACION - PROSA 2
/*
Para estos nuevos requerimientos se empieza creando un nuevo enum de TipoPrenda para la trama de la tela de la prenda.
Se crea una clase BORRADOR para guardar la ultima prenda que se carga, con los mismos atributos que una prenda solo con
el detalle de que si no se especifica ninguna trama para la tela esta sera LISA. Dentro de la clase ademas se hacen las
respectivas validaciones de Material, Color y Tipo.
BONUS
Para el bonus se creo una clase UNIFORME para la creacion de todos los uniformes que se pidan de ahora en adelante, haciendo
un method que permita contruir una prenda (contruirPrenda()) juntando las partes superiores, inferiores y calzado como minimo.
Como se dice que se quiere crean uniformes para distintas instituciones, se crea una interfaz para las instituciones las cuales
contenga la creacion de las distintas partes y de alli utilizan esta interfaz las distintas instituciones.
 */


//QMP1
//PRENDA
class Prenda{
    TipoPrenda tipo;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    TipoTela trama;

    public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario){
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    method cambiarTrama(TipoTela otraTrama){
        this.trama = otraTrama;
    }
    method esValida(TipoPrenda tipo, Material material, Color colorPrincipal){
        if(colorPrincipal == null  || tipo == null || material == null){
            throw new PrendaNoAptaException( "Faltan cargar datos requeridos" );
        }
    }

    method noTieneTrama(){
        if(trama == null){
            this.cambiarTrama(LISA);
        }
    }

}

//Tipo de la prenda

class TipoPrenda{
    Categoria categoria;
    List<Material> materialesValidos;

    method categoria() { return this.categoria; }
}

//Ejemplos
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

public enum TipoTela{
    LISA, RAYADA, LUNARES, CUADROS, ESTAMPADO
}

//EXPLICACION - PROSA 1
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