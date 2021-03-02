public interface MyList <E>{
    public <T extends MyList<E>> void insert(T list, E data);
    public <T extends MyList<E>> void deleteByKey(T list, E key);
    public void printLst(MyList<E> list);

}
