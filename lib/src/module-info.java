module lib {

    // modulele care vor avea o dependinta de lib
    // transitive, vor avea o dependinta si de
    // modulul java.rmi
    requires transitive java.rmi;
}