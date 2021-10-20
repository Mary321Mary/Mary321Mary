package lib;

import java.sql.Date;

public class LendingBooks {
    private int    kod;
    private int    iDBook;
    private String name;
    private int    iDEmpl;
    private Date   lendingDate;
    private Date   returnDate;

    LendingBooks(final int kod, final int iDBook, final String name, final int iDEmpl,
            final Date lendingDate, final Date returnDate) {
        this.kod = kod;
        this.iDBook = iDBook;
        this.name = name;
        this.iDEmpl = iDEmpl;
        this.lendingDate = lendingDate;
        this.returnDate = returnDate;
    }

    /**
     * @return the iDBook
     */
    public int getIDBook() {
        return this.iDBook;
    }

    /**
     * @return the iDEmpl
     */
    public int getIDEmpl() {
        return this.iDEmpl;
    }

    /**
     * @return the kod
     */
    public int getKod() {
        return this.kod;
    }

    /**
     * @return the lendingDate
     */
    public Date getLendingDate() {
        return this.lendingDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return this.returnDate;
    }

    /**
     * @param iDBook
     *            the iDBook to set
     */
    public void setIDBook(final int iDBook) {
        this.iDBook = iDBook;
    }

    /**
     * @param iDEmpl
     *            the iDEmpl to set
     */
    public void setIDEmpl(final int iDEmpl) {
        this.iDEmpl = iDEmpl;
    }

    /**
     * @param kod
     *            the kod to set
     */
    public void setKod(final int kod) {
        this.kod = kod;
    }

    /**
     * @param lendingDate
     *            the lendingDate to set
     */
    public void setLendingDate(final Date lendingDate) {
        this.lendingDate = lendingDate;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param returnDate
     *            the returnDate to set
     */
    public void setReturnDate(final Date returnDate) {
        this.returnDate = returnDate;
    }
}
