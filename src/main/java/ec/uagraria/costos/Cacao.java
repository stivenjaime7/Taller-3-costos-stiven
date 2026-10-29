package ec.uagraria.costos;

public record Cacao(String tipo) implements Cultivo {
    @Override
    public String nombreComun() {
        return "Cacao " + tipo;
    }
}