import model.DocumentType;
import model.LifecycleState;
import model.WTDocument;
import model.WTPart;

public class Main {

        public static void main(String[] args) {
                WTPart part1 = new WTPart(
                                "P1001",
                                "Gear Assembly",
                                "A",
                                LifecycleState.IN_WORK);

                WTPart part2 = new WTPart(
                                "P1002",
                                "Motor Housing",
                                "B",
                                LifecycleState.IN_WORK);

                WTPart part3 = new WTPart(
                                "P1003",
                                "Control Panel",
                                "C",
                                LifecycleState.RELEASED);

                // Documents for Part 1
                part1.addDocument(new WTDocument(
                                "D101",
                                "Gear Drawing",
                                DocumentType.CAD,
                                "A",
                                LifecycleState.RELEASED));

                part1.addDocument(new WTDocument(
                                "D102",
                                "Assembly Instructions",
                                DocumentType.PDF,
                                "A",
                                LifecycleState.RELEASED));

                // Documents for Part 2
                part2.addDocument(new WTDocument(
                                "D201",
                                "Housing Drawing",
                                DocumentType.CAD,
                                "B",
                                LifecycleState.IN_WORK));

                // Documents for Part 3
                part3.addDocument(new WTDocument(
                                "D301",
                                "Panel Layout",
                                DocumentType.CAD,
                                "C",
                                LifecycleState.RELEASED));

                part3.addDocument(new WTDocument(
                                "D302",
                                "Wiring Diagram",
                                DocumentType.PDF,
                                "C",
                                LifecycleState.RELEASED));

                part3.addDocument(new WTDocument(
                                "D303",
                                "Inspection Checklist",
                                DocumentType.DOCX,
                                "A",
                                LifecycleState.APPROVED));

                WTPart[] parts = { part1, part2, part3 };
                // AI Prompt : Give me updated code containing table format so we can read
                // easily.
                for (WTPart part : parts) {

                        System.out.println("\nPART DETAILS");
                        System.out.println(
                                        "----------------------------------------------------------------------------");
                        System.out.printf("| %-12s | %-20s | %-8s | %-15s |%n",
                                        "Part No", "Part Name", "Revision", "State");
                        System.out.println(
                                        "----------------------------------------------------------------------------");
                        System.out.println(part);

                        System.out.println("\nASSOCIATED DOCUMENTS");
                        System.out.println(
                                        "------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-15s | %-25s | %-15s | %-8s | %-15s |%n",
                                        "Document No", "Document Name", "Type", "Revision", "State");
                        System.out.println(
                                        "------------------------------------------------------------------------------------------------");

                        for (WTDocument document : part.getAssociatedDocuments()) {
                                System.out.println(document);
                        }

                        System.out.println(
                                        "------------------------------------------------------------------------------------------------");
                }
        }
}