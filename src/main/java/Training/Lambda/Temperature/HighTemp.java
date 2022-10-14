package Training.Lambda.Temperature;

public class HighTemp {
    private int hTemp;
    HighTemp (int ht){ hTemp = ht; }

    //возвратить логическое значение, если візівающий обект содержит такую же темп, как и обект 2
    boolean sameTemp(HighTemp ht2){
        return hTemp == ht2.hTemp;
    }

    //возвратить логическое значение, если візівающий обект содержит  темп ниже, как и обект 2
    boolean lessThanTemp(HighTemp ht2){
        return hTemp < ht2.hTemp;
    }
}
