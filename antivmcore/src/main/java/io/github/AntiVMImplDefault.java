/*
 * MIT License   Project AntiVM
 *
 * Copyright (c) 2017 Bunny Blue
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.github;

import android.content.Context;
import android.os.Process;

import io.github.antivm.IAntiVM;
import io.github.antivm.impl.AntiVMCloner;
import io.github.antivm.impl.AntiVMUninstalled;

/**
 * Created by bunny on 07/04/2017.
 */

public class AntiVMImplDefault extends IAntiVM {

    @Override
    public boolean onVMDetected(Context context) {
        AntiVMUninstalled antiVMUninstalled = new AntiVMUninstalled();
        if (antiVMUninstalled.onVMDetected(context)) {
            //DO Crash
            Process.killProcess(Process.myPid());
            return true;
        }
        AntiVMCloner antiVMCloner = new AntiVMCloner();
        if (antiVMCloner.onVMDetected(context)) {
            //DO Crash
            Process.killProcess(Process.myPid());
            return true;
        }

        return false;
    }
}
