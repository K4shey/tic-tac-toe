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

public class CellNumberConverter {

    private char[][] mappingTable = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3},
    };

    public Cell getCellByNumber(int number) {
        Cell result = null;

        for (int i = 0; i < mappingTable.length; i++) {
            for (int j = 0; j < mappingTable.length; j++) {
                if (mappingTable[i][j] == number) {
                    result = new Cell(i, j);
                    break;
                }
            }
        }
        return result;
    }

    public char getCharByCell(Cell cell) {
        return Character.forDigit(mappingTable[cell.getRow()][cell.getCol()], 10);
    }
}
