package Sem_6;


public class Cat {
    String name;
    int age;
    String poroda;
    String ownerName;

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age + ", poroda: " + poroda + ", owner: " + ownerName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Cat){
            Cat cat = (Cat) obj;
            return name.equals(cat.name) && age == cat.age
                    && poroda.equals(cat.poroda) && ownerName.equals(cat.ownerName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 7*age + 11*poroda.hashCode() + 17*ownerName.hashCode();
    }
}
