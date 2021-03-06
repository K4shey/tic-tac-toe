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

package academy.devonline.tictactoe.kepad;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.model.Cell;

public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {
    private char[][] mappingTable = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
    };

    @Override
    public Cell getCellByNumber(int number) {
        number--;
        return new Cell(number / 3, number % 3);
    }

    @Override
    public char getCharByCell(Cell cell) {
        return (char) ('0' + cell.getRow() * 3 + cell.getCol() + 1);
    }
}
