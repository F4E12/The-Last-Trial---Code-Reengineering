package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.managers.EnemyManager;

public interface ExitableState extends BossState {
    void exit(EnemyManager enemyManager);
}
