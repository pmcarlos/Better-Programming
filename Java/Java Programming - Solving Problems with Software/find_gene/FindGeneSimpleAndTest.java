
public class FindGeneSimpleAndTest
{
    
    public String findGene(String dna, String startCodon, String stopCodon) {
        startCodon.toUpperCase();
        stopCodon.toUpperCase();
        
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+2);
        if (stopIndex == -1){
            return "";
        }
        
        if((startIndex-stopIndex)%3 ==0){
            return dna.substring(startIndex, stopIndex+3);
        }
        
        return "";
    }
    
    
    public void testfindGene() {
        
        // First case: There's an ATG but no stop codon. No gene
        System.out.println("First case: There's an ATG but no stop codon. No gene");
        String dna = "TATGTATATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        // Second case: Stop codon is TAA. There's a Gene
        System.out.println("Second case: Stop codon is TAA. There's a Gene");
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene + "\n");
        
        // Forth case: No start gene case 
        System.out.println("Third case: Not multiple of 3");
        dna = "AATGAATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene + "\n");
        
        
    }
}
