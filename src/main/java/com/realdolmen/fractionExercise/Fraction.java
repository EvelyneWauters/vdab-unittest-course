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

    public Fraction subtracktFraction(Fraction fraction)    {
        int nieuweNoemer = this.noemer*fraction.getNoemer();
        int nieuweTeller = this.teller*fraction.getNoemer() - fraction.getTeller()*this.noemer;
        Fraction subtracktFraction = new Fraction(nieuweTeller,nieuweNoemer);
        subtracktFraction.simplify();
        return subtracktFraction;

    }

    public Fraction multiplyFraction(Fraction fraction) {
        Fraction multipliedFraction = new Fraction(this.teller * fraction.getTeller(), (this.noemer * fraction.getNoemer()));
        multipliedFraction.simplify();
        return multipliedFraction;
    }

    public Fraction divideFraction(Fraction fraction)   {
        if(fraction.getTeller()==0 || this.getTeller()==0) {
            return new Fraction(0,1);
        } else {
            Fraction multipliedFraction = this.multiplyFraction(fraction.reciprocal());
            multipliedFraction.simplify();
            return multipliedFraction;
        }
    }

    public Fraction simplify()  {
        int i = Utilities.greatestCommonFactor(teller, noemer);
        teller = teller/i;
        noemer = noemer/i;
        if(noemer<0)    {
            noemer = Math.abs(noemer);
            teller = -teller;
        }
        return new Fraction(teller, noemer);

    }

    public Fraction reciprocal()    {
        return new Fraction(this.noemer, this.teller);
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;
        this.simplify();
        fraction.simplify();

        if (teller != fraction.teller) return false;
        return noemer == fraction.noemer;

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
