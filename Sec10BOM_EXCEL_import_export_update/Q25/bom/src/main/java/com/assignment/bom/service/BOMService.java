package com.assignment.bom.service;

import com.assignment.bom.model.Part;
import com.assignment.bom.model.PartUsageLink;
import java.util.*;

// In-memory storage for parts and BOM links [cite: 10]
public class BOMService {
    private Map<String, Part> partDatabase = new HashMap<>();
    private List<PartUsageLink> bomLinks = new ArrayList<>();

    public void addPart(Part part) {
        partDatabase.put(part.getPartNumber(), part);
    }

    public Part getPart(String partNumber) {
        return partDatabase.get(partNumber);
    }

    public boolean linkExists(String parentNo, String childNo) {
        return bomLinks.stream().anyMatch(link -> link.getParentPart().getPartNumber().equals(parentNo) &&
                link.getChildPart().getPartNumber().equals(childNo));
    }

    public PartUsageLink getLink(String parentNo, String childNo) {
        return bomLinks.stream().filter(link -> link.getParentPart().getPartNumber().equals(parentNo) &&
                link.getChildPart().getPartNumber().equals(childNo)).findFirst().orElse(null);
    }

    public void addLink(PartUsageLink link) {
        bomLinks.add(link);
    }

    public void removeLink(PartUsageLink link) {
        bomLinks.remove(link);
    }

    // Checks for circular references [cite: 256]
    public boolean createsCircularReference(String parentNo, String childNo) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(childNo);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(parentNo))
                return true;
            visited.add(current);

            for (PartUsageLink link : bomLinks) {
                if (link.getParentPart().getPartNumber().equals(current)
                        && !visited.contains(link.getChildPart().getPartNumber())) {
                    queue.add(link.getChildPart().getPartNumber());
                }
            }
        }
        return false;
    }
}