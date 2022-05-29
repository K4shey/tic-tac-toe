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

import java.util.Scanner;

public class UsersMove {

    private final CellNumberConverter cellNumberConverter;

    public UsersMove(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void MakeMove(GameTable gameTable) {

        Cell cell = null;
        while (true) {
            Integer cellNumber = 0;
            while (!(cellNumber >= 1 && cellNumber <= 9)) {
                System.out.println("Please type number between 1 and 9:");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    cellNumber = scanner.nextInt();
                }
            }
            cell = cellNumberConverter.getCellByNumber(cellNumber);
            if (gameTable.isEmpty(cell)) {
                break;
            }
            System.out.println("Can't make a move, because the cell is not free! Try again!");
        }
        gameTable.setSign(cell, 'X');
    }
}
