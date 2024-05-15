package com.andro.control_ladder_game.ladder_library

class LadderMaster {
    private val ladderRepo = LadderRepository
    private val userDataList = ladderRepo.getHorseDataList()
    private val resultManager = LadderResultManager(
        ladderRepo.getProbabilityDataList(),
        ladderRepo.getProbabilityDataList().size,
        ladderRepo.absoluteNumber
    )
    private val ladderMaker = LadderMaker(ladderRepo.getHorseDataList().size)

    init{
        ladderMaker.makeLadderMap()
    }

    fun getLadder() = ladderMaker.getLadderMap()
}