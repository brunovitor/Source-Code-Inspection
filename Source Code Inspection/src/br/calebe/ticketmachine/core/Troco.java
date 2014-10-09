package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class Troco {

    protected PapelMoeda[] papeisMoeda;
    int valorAux;
    
    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        this.valorAux = valor;
        
        int count = 0;
        while (valorAux % 100 != 0) {
            count++;
        }papeisMoeda[5] = new PapelMoeda(100, count);
        valorAux %= 100;
        
        
        count = 0;
        while (valorAux % 50 != 0) {
            count++;
        }papeisMoeda[4] = new PapelMoeda(50, count);
        valorAux %= 50;
        
        count = 0;
        while (valorAux % 20 != 0) {
            count++;
        }papeisMoeda[3] = new PapelMoeda(20, count);
        valorAux %= 20;
        
        count = 0;
        while (valorAux % 10 != 0) {
            count++;
        }papeisMoeda[2] = new PapelMoeda(10, count);
        valorAux %= 10;
        
        count = 0;
        while (valorAux % 5 != 0) {
            count++;
        }papeisMoeda[1] = new PapelMoeda(5, count);
        valorAux %= 5;
        
        count = 0;
        while (valorAux % 2 != 0) {
            count++;
        }papeisMoeda[0] = new PapelMoeda(2, count);
        //valorAux %= 2;
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 5; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 5; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                    return ret;
                }
            }
            return null;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
