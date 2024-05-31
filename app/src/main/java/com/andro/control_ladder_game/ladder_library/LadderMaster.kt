package com.andro.control_ladder_game.ladder_library

/**
 * ## LadderMaster
 *   - mediator of Ladder Library with UI
 *   - Instance on starting to execute the ladder game logic.
 *   - In the ladder app, it is built at GameViewModel.
 *   - When starting, it reads the data of LadderRepository.
 *   - The list of data are probabilities of result each horses and use_case(user list, etc.).
 *   - Finishing to read the data, it starts to make instances of
 *      LadderResultManager and LadderUiMaker progressively.
 *   - Finished this process, it transfers result of this game into
 *     LadderRepository and GameFragment.
 *   - Then it starts to play ladder game.*/
class LadderMaster (private val ladderRepo : LadderRepository = LadderRepository){
    /**
     * userList에 대한 결과를 resultManager에서 ladderMaker로 경로를 전달
     **/

    private val boomer = 0

    private val ladderMaker = LadderMaker(ladderRepo.getHorseDataList().size)
    private val resultManager = LadderResultManager(
        ladderRepo.getHorseDataList().size,
        ladderRepo.getProbabilityDataList(),
        ladderRepo.absoluteNumber
    )

    private val ladderRouteNavigator = LadderRouteNavigator(ladderMaker.getLadderMap())
    
    /**
     * 사다리 형상을 반환합니다
     * 화면에 맞는 마진값을 포함하고 말이죠.*/
    fun getLadderMap(w : Int, h : Int) : List<List<Int>>{
        ladderMaker.getLadderMap()

        return ladderMaker.getLadderMap()
    }

    fun getLadderMap(w : Float, h : Float) : List<List<Int>>{
        ladderMaker.getLadderMap()

        return ladderMaker.getLadderMap()
    }

    /**
     * 재배치된 사다리 말을 반환합니다*/
    fun getLadderHorseList() {
        setRearrangeHorseList()
    }


    private fun setRearrangeHorseList(){

    }
}