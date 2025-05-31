package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.managers.EnemyManager;

public interface ExitableState extends BossState {
    void exit(EnemyManager enemyManager);
}
