package lib;

public class Author {
    private int    kod;
    private String name;
    private int    iDBook;

    Author(final int kod, final String name, final int iDBook) {
        this.kod = kod;
        this.name = name;
        this.iDBook = iDBook;
    }

    /**
     * @return the iDBook
     */
    public int getiDBook() {
        return this.iDBook;
    }

    /**
     * @return the kod
     */
    public int getKod() {
        return this.kod;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param iDBook
     *            the iDBook to set
     */
    public void setiDBook(final int iDBook) {
        this.iDBook = iDBook;
    }

    /**
     * @param kod
     *            the kod to set
     */
    public void setKod(final int kod) {
        this.kod = kod;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

}
