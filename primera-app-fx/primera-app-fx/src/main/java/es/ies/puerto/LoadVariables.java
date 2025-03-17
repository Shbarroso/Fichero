package es.ies.puerto;

public class LoadVariables {
    Idioma defauld = Idioma.ESPANIOL;

    public void loadIdioma(Idioma idioma){
        idioma = "ingles".toUpperCase();
        if (idioma == null) {
            idioma = "AA";
        }
        switch (idioma) {
            case FRANCES:
                
                break;
            case INGLES:

                break;
            default:
                break;
        }
    }
}
