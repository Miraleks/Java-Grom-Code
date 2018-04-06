package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if(!o1.getChannelName().equals(o2.getChannelName()))
            return o1.getChannelName().compareTo(o2.getChannelName());
        if(!o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        if(!o1.getDateCreated().equals(o2.getDateCreated()))
            return o1.getDateCreated().compareTo(o2.getDateCreated());

        return 0;
    }
}
