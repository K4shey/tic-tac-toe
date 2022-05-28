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

package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

public class WinnerCheck {
    public boolean isUserWin(GameTable gameTable) {
        return haveWinner(gameTable, 'X');
    }

    public boolean isComputerWin(GameTable gameTable) {
        return haveWinner(gameTable, '0');
    }

    private boolean haveWinner(GameTable gameTable, char sign) {

        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == sign &&
                    gameTable.getSign(new Cell(i, 1)) == sign &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == sign &&
                    gameTable.getSign(new Cell(1, i)) == sign &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }

        if (gameTable.getSign(new Cell(0, 0)) == sign &&
                gameTable.getSign(new Cell(1, 1)) == sign &&
                gameTable.getSign(new Cell(2, 2)) == sign) {
            return true;
        }

        if (gameTable.getSign(new Cell(0, 2)) == sign &&
                gameTable.getSign(new Cell(1, 1)) == sign &&
                gameTable.getSign(new Cell(2, 0)) == sign) {
            return true;
        }
        return false;
    }
}
