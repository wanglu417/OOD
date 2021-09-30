public class TopScoreTrackerImpl implements TopScoreTracker {
    public OrderedList<Run> M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12;
    public OrderedListImpl<Run> yearly;
    public int monthlyTopN;
    public int yearlyTopM;

    public TopScoreTrackerImpl(int monthlyTopN, int yearlyTopM) {
        this.monthlyTopN = monthlyTopN;
        this.yearlyTopM = yearlyTopM;
        this.M1 = new OrderedListImpl<Run>(monthlyTopN);
        this.M2 = new OrderedListImpl<Run>(monthlyTopN);
        this.M3 = new OrderedListImpl<Run>(monthlyTopN);
        this.M4 = new OrderedListImpl<Run>(monthlyTopN);
        this.M5 = new OrderedListImpl<Run>(monthlyTopN);
        this.M6 = new OrderedListImpl<Run>(monthlyTopN);
        this.M7 = new OrderedListImpl<Run>(monthlyTopN);
        this.M8 = new OrderedListImpl<Run>(monthlyTopN);
        this.M9 = new OrderedListImpl<Run>(monthlyTopN);
        this.M10 = new OrderedListImpl<Run>(monthlyTopN);
        this.M11 = new OrderedListImpl<Run>(monthlyTopN);
        this.M12 = new OrderedListImpl<Run>(monthlyTopN);
        this.yearly = new OrderedListImpl<Run>(yearlyTopM);
    }

    @Override
    public void addRun(int m, Run r) {
      if(m==1){
          M1.add(r);
      }
      if(m==2){
          M2.add(r);
      }
      if(m==3) {
          M3.add(r);
      }
      if(m==4){
          M4.add(r);
      }
      if(m==5){
          M5.add(r);
      }
      if(m==6){
          M6.add(r);
      }
      if(m==7){
          M7.add(r);
      }
      if(m==8){
          M8.add(r);
      }
      if(m==9){
          M9.add(r);
      }
      if(m==10){
          M10.add(r);
      }
      if(m==11){
          M11.add(r);
      }
      if(m==12){
          M12.add(r);
      }
    }

    @Override
    public String annualReport() {
        OrderedList<Run> yearly = M1.merge(M2.merge(M3.merge(M4.merge(M5.merge(M6.merge(M7.merge(M8.merge(M9.merge(M10.merge(M11.merge(M12)))))))))));
        yearly.resize(yearlyTopM);
        String annual = yearly.toString();
        return annual;
    }
}
