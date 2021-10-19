package edu.parinya.softarchdesign.structural;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    private final Set<HealthcareServiceable> members;

    HealthcareWorkerTeam() {
        members = new LinkedHashSet<>();
    }

    public void addMember(HealthcareServiceable worker) {
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        members.remove(worker);
    }

    public void service() {
        for(HealthcareServiceable member : members) {
            member.service();
        }
    }

    public double getPrice() {
        double total = 0;
        for(HealthcareServiceable member : members) {
            total += member.getPrice();
        }

        return total;
    }

}
