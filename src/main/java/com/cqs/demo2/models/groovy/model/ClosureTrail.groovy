/**
 * Created by li on 2015/12/4.
 */
class ClosureTrail {

    def greeting = "Hello";
    def clos = {
        parm -> println "${greeting} ${parm}"
    }


    def f1(){
        clos('shortcut')
        clos.call('shortcut')
        demo(clos)
    }



    def demo(cols){
        println()
        greeting = "Method"

        def clos2 = {
            3.times { println "重要的事情说三遍${it}"}
        }

        5.times {

        }

        cols("DEMO")
        clos2()
    }

    public static void main(String[] args) {
        ClosureTrail trail = new ClosureTrail();
        trail.f1();
        trail.demo(trail.clos)
    }


}

