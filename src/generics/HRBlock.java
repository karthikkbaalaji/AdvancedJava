package generics;

import java.util.List;


class Taxable /* extends Object */ {}
class Individual extends Taxable {}
class Corportation extends Taxable {}

public class HRBlock {

    public static void collectCustomers(List <? super Taxable> list) {
        Taxable t = /* look up in database */ new Taxable();
        // t might be Taxable or an Object
        // however, it _will_ be possible to assign from t to "?"
        // becaues "?" is either Taxable or a generalization thereof
        list.add(t);
    }
    
    public static void batchProcess(List <? extends Taxable> list) {
        // assigning the "?" type of the list into the Taxable t
        // will definitely work, because "?" is either Taxable, Individual, or a Corporation
        for (Taxable t : list) {
            // do stuff with t.
        }
    }
    
    public static void collectBroken(List<? extends Taxable> list) {
        Taxable t = /* look up in database */ new Taxable();
        // this is not safe, since "?" might be Individual or Corporation,
        // and those list types cannot accept general Taxables
        list.add(t);
    }

    public static void batchBroken(List <? super Taxable> list) {
        // assigning the "?" type of the list into the Taxable t
        // is not safe, because "?" might be an Object
        for (Taxable t : list) {
            // do stuff with t.
        }
    }
    
    public static void invocations() {
        // can hold "anything", but can't make assumptions about what you get out of this
        List<Object> lo = null;
        // so this works, as the list can hold anything
        collectCustomers(lo); 
        
        // this fails, as it might contain objects, which cannot be treated as Taxable
        batchProcess(lo); 

// -----------------------------------------------------------------------

        List<Individual> li = null;

        // this fails, as the ading process might try to put Corporation, or Taxable into the list
        collectCustomers(li);

        // this succeeds, because every individual is a Taxable
        batchProcess(li);
        
// -----------------------------------------------------------------------

        List<Taxable> lt = null;

        // this works, as anything that gets added will be Taxable, or assignment compatible
        collectCustomers(lt);

        // this succeeds too, everything is exactly as expected.
        batchProcess(lt);
   
    }
}
