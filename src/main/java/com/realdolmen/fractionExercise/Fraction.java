package com.realdolmen.fractionExercise;


public class Fraction {
    private int teller;
    private int noemer;


    public Fraction(int teller, int noemer) {
        this.teller = teller;
        this.noemer = setNoemerVoorConstructor(noemer);
    }

    public Fraction() {
    }

    public String toString()   {
        return teller+"/"+noemer;
    }

    public double asDouble()    {
        return ((double)teller)/noemer;
    }

    public Fraction sumFraction(Fraction fraction)  {
        int nieuweNoemer = this.noemer*fraction.getNoemer();
        int nieuweTeller = this.teller*fraction.getNoemer() + fraction.getTeller()*this.noemer;
        Fraction sumFraction = new Fraction(nieuweTeller,nieuweNoemer);
        sumFraction.simplify();
        return sumFraction;
    }

    public Fraction multiplyFraction(Fraction fraction) {
        Fraction multipliedFraction = new Fraction(this.teller * fraction.getTeller(), (this.noemer * fraction.getNoemer()));
        multipliedFraction.simplify();
        return multipliedFraction;
    }

    public Fraction divideFraction(Fraction fraction)   {
        if(fraction.getTeller()==0) {
            return new Fraction(0,1);
        } else {
            Fraction multipliedFraction = new Fraction(this.teller * fraction.getNoemer(), (this.noemer * fraction.getTeller()));
            multipliedFraction.simplify();
            return multipliedFraction;
        }
    }

    public Fraction simplify()  {
        int i = Utilities.greatestCommonFactor(teller, noemer);
        teller = teller/i;
        noemer = noemer/i;
        return new Fraction(teller, noemer);
    }

    public boolean equalsFraction(Fraction a)    {
        a.simplify();
        this.simplify();
        if (a.getTeller()==this.teller || a.getNoemer()==this.noemer)    {
            return true;
        } else  {
            return false;
        }
    }

    public int getNoemer() {
        return noemer;
    }

    public void setNoemer(int noemer) {
        if(noemer != 0) {
            this.noemer = noemer;
        } else  {
            throw new ForbiddenDenominatorException("Noemer mag niet 0 zijn");
        }
    }

    private int setNoemerVoorConstructor(int noemer)   {
        if(noemer != 0) {
            this.noemer = noemer;
            return noemer;
        } else  {
            throw new ForbiddenDenominatorException("Noemer mag niet 0 zijn");
        }
    }

    public int getTeller() {
        return teller;
    }

    public void setTeller(int teller) {
        this.teller = teller;
    }
}
