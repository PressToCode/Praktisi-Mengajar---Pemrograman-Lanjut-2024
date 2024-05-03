public class GenericClass <T> {
    private T dataPertama;
    
    public GenericClass(T dataPertama) {
        this.dataPertama = dataPertama;
    }
    
    public T getDataPertama() {
        return this.dataPertama;
    }
    
    public void setDataPertama(T dataPertama) {
        this.dataPertama = dataPertama;
    }
}
