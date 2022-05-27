/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package academy.devonline.tictactoe;

import java.util.Random;

public class Game {
    private final ScreenOutput screenOutput;
    private final ComputersMove computersMove;
    private final UsersMove usersMove;
    private final WinnerCheck winnerCheck;
    private final DrawCheck drawCheck;

    public Game(ScreenOutput screenOutput,
                ComputersMove computersMove,
                UsersMove usersMove,
                WinnerCheck winnerCheck,
                DrawCheck drawCheck) {
        this.screenOutput = screenOutput;
        this.computersMove = computersMove;
        this.usersMove = usersMove;
        this.winnerCheck = winnerCheck;
        this.drawCheck = drawCheck;
    }

    public void play() {
        final GameTable gameTable = new GameTable();
        screenOutput.DrawMappingTable();
        if (new Random().nextBoolean()) {
            computersMove.MakeMove(gameTable);
            screenOutput.DrawGameTable(gameTable);
        }

        while (true) {
            usersMove.MakeMove(gameTable);
            screenOutput.DrawGameTable(gameTable);

            if (winnerCheck.isUserWin()) {
                System.out.println("YOU WIN!");
                break;
            } else if (drawCheck.isDraw()) {
                System.out.println("DRAW!");
                break;
            }

            computersMove.MakeMove(gameTable);
            screenOutput.DrawGameTable(gameTable);

            if (winnerCheck.isComputerWin()) {
                System.out.println("COMPUTER WIN!");
                break;
            } else if (drawCheck.isDraw()) {
                System.out.println("DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER");
    }
}