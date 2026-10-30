package ec.uagraria.costos;
import java.util.List;
public record Lote(String codigo, Cultivo cultivo, double hectareas, List<Insumo> insumos) {
    public double costoInsumos() {
        double total = 0.0;
        for (Insumo i : insumos) { total += i.costo(); }
        return total;
    }
    public int jornalesPorHectarea() {
        if (cultivo instanceof Banano) { return 18; }
        if (cultivo instanceof Cacao) {
            Cacao c = (Cacao) cultivo;
            if (c.tipo().toLowerCase().contains("organico")) { return 25; } else { return 20; }
        }
        if (cultivo instanceof Arroz) {
            Arroz a = (Arroz) cultivo;
            return 12 * a.ciclosPorAnio();
        }
        return 10;
    }
}