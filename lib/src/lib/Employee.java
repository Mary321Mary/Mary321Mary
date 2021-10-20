package lib;

import java.sql.Date;

public class Employee {
    private int    kod;
    private String name;
    private String position;
    private Date   recruitDate;
    private Date   dismidDate;

    Employee(final int kod, final String name, final String position, final Date recruitDate,
            final Date dismidDate) {
        this.setKod(kod);
        this.setName(name);
        this.setPosition(position);
        this.setRecruitDate(recruitDate);
        this.setDismidDate(dismidDate);
    }

    /**
     * @return the dismidDate
     */
    public Date getDismidDate() {
        return this.dismidDate;
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
     * @return the position
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * @return the recruitDate
     */
    public Date getRecruitDate() {
        return this.recruitDate;
    }

    /**
     * @param dismidDate
     *            the dismidDate to set
     */
    public void setDismidDate(final Date dismidDate) {
        this.dismidDate = dismidDate;
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

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(final String position) {
        this.position = position;
    }

    /**
     * @param recruitDate
     *            the recruitDate to set
     */
    public void setRecruitDate(final Date recruitDate) {
        this.recruitDate = recruitDate;
    }

}
