package defPack;
import java.util.*;


/**
 * Created by aalokhin on 2/2/19.
 */
public class Tower {

    private List<Flyable>  aircrafts = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        if (flyable != null) {
            if (aircrafts.contains(flyable))
                return;
            aircrafts.add(flyable);
            Result.resultBuilder.append("Tower says: ");
        }

    }
    public void unregister(Flyable flyable)
    {
        if (flyable != null && aircrafts.contains(flyable)) {
            aircrafts.remove(flyable);
            Result.resultBuilder.append("Tower says: ");
        }

    }

    protected void conditionsChanged()
    {
        int i = 0;
        while (i < aircrafts.size())
        {
            aircrafts.get(i).updateConditions();
            i++;
        }

    }
}
