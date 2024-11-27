public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int initialTonerLevel, boolean isDuplex){

        if(initialTonerLevel < 0){
            this.tonerLevel = 0;
        } else if (initialTonerLevel > 100) {
            this.tonerLevel = -1;
        } else {
            this.tonerLevel = initialTonerLevel;
        }

        this.isDuplex = isDuplex;
        this.pagesPrinted = 0;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public void setTonerLevel(int tonerLevel){
        this.tonerLevel = tonerLevel;
    }

    public void setPagesPrinted(int pagesPrinted) {
        this.pagesPrinted = pagesPrinted;
    }

    public void setDuplex(boolean duplex) {
        isDuplex = duplex;
    }

    public int addToner (int tonerAmount){

        setTonerLevel(this.getTonerLevel() + tonerAmount);

        if (this.getTonerLevel() > 100) {
            this.setTonerLevel(-1); // weird, but its the test assignment
        }
        if (this.getTonerLevel() < 0){
            this.setTonerLevel(0);
        }

        return this.getTonerLevel();
    }

    public int printPages(int numberOfPages){

        int printedPages = 0;

        if(this.isDuplex()){

            System.out.println("The printer is a duplex printer.");

            printedPages = Math.ceilDiv(numberOfPages, 2); // or: (numberOfPages / 2) + (numberOfPages % 2)
            this.setPagesPrinted(this.getPagesPrinted() + printedPages);
        } else {

            printedPages = numberOfPages;
            this.setPagesPrinted(this.getPagesPrinted() + printedPages);
        }

        return printedPages;
    }
}
