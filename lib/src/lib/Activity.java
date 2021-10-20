package lib;

import java.sql.Date;

public class Activity {
    private int    kod;
    private String name;
    private int    iDEmpl;
    private Date   activityDate;

    Activity(final int kod, final String name, final int iDEmpl, final Date activityDate) {
        this.setKod(kod);
        this.setName(name);
        this.setiDEmpl(iDEmpl);
        this.setActivityDate(activityDate);
    }

    /**
     * @return the activityDate
     */
    public Date getActivityDate() {
        return this.activityDate;
    }

    /**
     * @return the iDEmpl
     */
    public int getiDEmpl() {
        return this.iDEmpl;
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
     * @param activityDate
     *            the activityDate to set
     */
    public void setActivityDate(final Date activityDate) {
        this.activityDate = activityDate;
    }

    /**
     * @param iDEmpl
     *            the iDEmpl to set
     */
    public void setiDEmpl(final int iDEmpl) {
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
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

}
