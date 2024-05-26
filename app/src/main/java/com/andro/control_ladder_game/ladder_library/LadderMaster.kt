package com.andro.control_ladder_game.ladder_library

/**
 * ## LadderMaster
 *   - Instance on starting to execute the ladder game logic.
 *   - In the ladder app, it is built at GameViewModel.
 *   - When starting, it reads the data of LadderRepository.
 *   - The list of data are probabilities of result each horses,
        and use_case(user list, etc.).
 *   - Finishing to read the data, it starts to make instances of
 *     LadderResultManager and LadderUiMaker progressively.
 *   - Finished this process, it transfers result of this game into
 *     LadderRepository and GameFragment.
 *   - Then it starts to play ladder game.*/
class LadderMaster {
    private val ladderRepo = LadderRepository
    /**
     * userList에 대한 결과를 resultManager에서 ladderMaker로 경로를 전달해 줘야 해
     **/
    private val resultManager = LadderResultManager(ladderRepo.getProbabilityDataList(),
        ladderRepo.absoluteNumber)

    private var ladderMaker : LadderMaker = LadderMaker(resultManager.getRouteList())

    private fun setResultInRepository(){

    }

    private fun setRouteInRepository(){

    }
}