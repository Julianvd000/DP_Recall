"# DP_Recall" 

        klasDAOimpl klasDAO = new klasDAOimpl();
        volgtDAOimpl volgtDAO = new volgtDAOimpl();
        studentDAOimpl studentDAO = new studentDAOimpl();
        //krijg alle klassen
        List<klas> klassen = klasDAO.findAll();
        for (klas klas: klassen) {
            System.out.println(klas.toString());
        }
        //krijg alle studenten uit de klas v1e
        List<student> studenten = klasDAO.findbyKlasCode("V1E");

        for (student student : studenten){
            System.out.println(student.toString());
        }
        //een leerling met all zijn vakken.
        String Naam = "Julian";
        student studentOpgehaald = studentDAO.getStudent(Naam);
        List<volgt> volgingStudent = volgtDAO.findbyStudent(studentOpgehaald);
        List<vak> vakken = new ArrayList<vak>();

        for (volgt volgt: volgingStudent) {
            vakken.add(volgt.getVak());
        }
        studentOpgehaald.setVakken(vakken);

        System.out.println(studentOpgehaald.toString());
        
        ~~~~~~~~~~~~~~~~~~~~~~~~~~
       de klas V1A en begonnen in 2018
       de klas V1B en begonnen in 2018
       de klas V1C en begonnen in 2018
       de klas V1D en begonnen in 2018
       de klas V1E en begonnen in 2018
       Mark zit in de klas V1E en begonnen in 2018
       Luuk zit in de klas V1E en begonnen in 2018
       Julian zit in de klas V1E en begonnen in 2018
       Julian zit in de klas V1E en begonnen in 2018 en heeft de vakken: DP, heeft de naam Data processing en het aantal punten 5, 