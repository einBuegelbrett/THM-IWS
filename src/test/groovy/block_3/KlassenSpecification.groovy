package block_3

import spock.lang.Specification

class KlassenSpecification extends Specification {

    def "vibeStatus gibt korrekten String zurück"() {
        given:
        def groover = new Groover(
                stageName: "Jimi",
                instrument: "Stratocaster",
                vibeLevel: 90
        )

        expect:
        groover.vibeStatus() == "Jimi rockt die Stratocaster"
    }

    def "isReadyToParty ist true bei VibeLevel >= 80"() {
        expect:
        new Groover(stageName: "Jimi", instrument: "Gitarre", vibeLevel: 80)
                .isReadyToParty()
    }

    def "isReadyToParty ist false bei VibeLevel < 80"() {
        expect:
        !new Groover(stageName: "Bob", instrument: "Luftgitarre", vibeLevel: 50)
                .isReadyToParty()
    }

    def "countSongs gibt Anzahl der Songs zurück"() {
        given:
        def groover = new Groover(
                stageName: "Jimi",
                instrument: "Gitarre",
                vibeLevel: 90,
                setlist: ["Voodoo Child", "Hey Joe"]
        )

        expect:
        groover.countSongs() == 2
    }

    def "getOpeningSong gibt ersten Song zurück"() {
        given:
        def groover = new Groover(
                stageName: "Jimi",
                instrument: "Gitarre",
                vibeLevel: 90,
                setlist: ["Voodoo Child", "Hey Joe"]
        )

        expect:
        groover.getOpeningSong() == "Voodoo Child"
    }

    def "getOpeningSong gibt Default zurück wenn Setlist leer"() {
        given:
        def groover = new Groover(
                stageName: "Bob",
                instrument: "Luftgitarre",
                vibeLevel: 40,
                setlist: []
        )

        expect:
        groover.getOpeningSong() == "Noch keine Songs"
    }

    def "festivalCard kombiniert Status und VibeLevel"() {
        given:
        def groover = new Groover(
                stageName: "Jimi",
                instrument: "Stratocaster",
                vibeLevel: 90
        )

        expect:
        groover.festivalCard() == "Jimi rockt die Stratocaster (Vibe: 90%)"
    }
}
