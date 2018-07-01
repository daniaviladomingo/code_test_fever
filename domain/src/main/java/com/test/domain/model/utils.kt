package com.test.domain.model

enum class RACE {
    HUMAN, BETAZOID, VULCAN;

    companion object {
        val random: RACE
            get() = values()[(Math.random() * values().size).toInt()]
    }
}

enum class COLOR { BLUE, RED, YELLOW, OTHER }

enum class AREAS { SCIENCE, ENGINEERING, COMMAND;

    companion object {
        val random: AREAS
            get() = values()[(Math.random() * values().size).toInt()]

        fun getColor(areas: String): COLOR {
            return when {
                areas.equals(SCIENCE.name, ignoreCase = true) -> COLOR.BLUE
                areas.equals(ENGINEERING.name, ignoreCase = true) -> COLOR.RED
                areas.equals(COMMAND.name, ignoreCase = true) -> COLOR.YELLOW
                else -> COLOR.OTHER
            }
        }
    }
}
