App.main p1,2,3
```
 Klas klas1 = new Klas("V1F", "Meneer Janssen", 2019);
        Student student1 = new Student(00001, "Julian van Dijk", null, "V1F");
        Vak vak1 = new Vak("PRG", "Programmeren", 5);
        Volgt volgt1 = new Volgt(00001, "PRG");

        Klas klas2 = new Klas("V1G", "Wilma Petersen", 2020);
        Student student2 = new Student(00001, "maxmim hauss", null, "V1G");
        Vak vak2 = new Vak("WAC", "Web Application Construction", 5);
        //Testen of save() werkt
        System.out.println("save() test:");

        System.out.println("save klas " + klasdao.save(klas1));
        System.out.println("save student " + studentdao.save(student1));
        System.out.println("save vak " + vakdao.save(vak1));
        System.out.println("save volgt " + volgtdao.save(volgt1));

        //Testen of delete() werkt
        System.out.println("delete() test:");
        System.out.println("delete volgt " + volgtdao.delete(volgt1));
        System.out.println("delete vak " + vakdao.delete(vak1));
        System.out.println("delete student " + studentdao.delete(student1));
        System.out.println("delete klas " + klasdao.delete(klas1));

        //Testen of update() werkt
        System.out.println("update() test:");
        System.out.println("update vak " + vakdao.update(vak2));
        System.out.println("update student " + studentdao.update(student2));
        System.out.println("update klas " + klasdao.update(klas2));

        //Herstelt oude waarden om later opnieuw update() te kunnen testen

```
```
save() test:
save klas dprecall.entitys.Klas@1d119efb
save student dprecall.entitys.Student@2473d930
save vak dprecall.entitys.Vak@769f71a9
save volgt dprecall.entitys.Volgt@6f96c77
delete() test:
delete volgt true
delete vak true
delete student true
delete klas true
update() test:
update vak dprecall.entitys.Vak@470f1802
update student dprecall.entitys.Student@3e92efc3
update klas dprecall.entitys.Klas@2e4b8173
```

